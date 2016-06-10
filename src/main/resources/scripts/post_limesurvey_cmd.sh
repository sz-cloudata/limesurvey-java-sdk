#! /bin/bash

#: ----------------------------------------------------------------
#: File name:	post_limesurvey_cmd.sh
#: Author:	DORSEy Q F TANG
#: Date:	Feb 16th, 2016
#: Description:	This is the script for testing post limesurvey commands
#: ----------------------------------------------------------------

#: start of the script
CUR_DIR=$(dirname $0)
CUR_DIR=$(cd $CUR_DIR; pwd)

THIS_SCRIPT=$(basename $0)

#: the usage description
function usage() {
	printf "Usage: %s -m <method> -p <params>\n" $THIS_SCRIPT
	printf "%s -m get_session_key -p username=yunshu password=z\n" $THIS_SCRIPT
	printf "%s -m get_survey_properties -p sSessionKey=xx iSurveyID=1 aSurveySetting=[hello,world]\n" $THIS_SCRIPT
	printf "%s -m set_survey_properties -p sSessionKey=xx iSurveyID=1 aSurveyData={feng:dorsey}\n" $THIS_SCRIPT
	exit 1
}

function read_parathesis() {
	CONTENT=$(echo $1 | awk -F'{' '{print $2}' | awk -F'}' '{print $1}')
	OLD_IFS=$IFS
	IFS=","
	CONTENT_ARR=($CONTENT)
	IFS="$OLD_IFS"

	PARAMS="{"
	ARR_LEN=${#CONTENT_ARR[*]}
	POS=0
	while [ $POS -lt $ARR_LEN ];
	do
		PARAM_KEY=$(echo ${CONTENT_ARR[$POS]} | awk -F':' '{print $1}')
		PARAM_VALUE=$(echo ${CONTENT_ARR[$POS]} | awk -F':' '{print $2}')
		
		PARAMS="$PARAMS""\"$PARAM_KEY\": \"$PARAM_VALUE\""
		if (( POS < ARR_LEN - 1 ));
		then
			PARAMS="$PARAMS, "
		fi

		(( POS += 1 ))
	done

	echo "$PARAMS}"
}

#: parsing the content in squar
function read_brackets() {
	CONTENT=$(echo "$1" | awk -F'[' '{print $2}' | awk -F']' '{print $1}')
	OLD_IFS=$IFS
	IFS=","
	CONTENT_ARR=($CONTENT)
	IFS="$OLD_IFS"

	CONTENT_ARR_LEN=${#CONTENT_ARR[*]}
	POS=0
	PARAMS="["
	while [ $POS -lt $CONTENT_ARR_LEN ];
	do
		PARAMS="$PARAMS""\"${CONTENT_ARR[$POS]}\""
		if (( POS < CONTENT_ARR_LEN - 1 ));
		then
			PARAMS="$PARAMS, "
		fi

		(( POS += 1 ))
	done

	echo "$PARAMS]"
}

NUM_ARGS=$#
if test $NUM_ARGS -lt 4;
then
	usage
fi

LS_METHOD=
IN_PARAMS=
INDEX=0
while (( INDEX < NUM_ARGS ));
do
	case $1 in
		-m)
			LS_METHOD="$2"
			shift 2
			(( INDEX += 2 ))
			;;
		-p)
			shift
			(( INDEX += 1 ))
			
			#: loop for input params
			while (( INDEX < NUM_ARGS))
			do
				PARAM_NAME=$(echo $1 | awk -F'=' '{print $1}')
				PARAM_VALUE=$(echo $1 | awk -F'=' '{print $2}')
				PARAMS="$PARAMS""\"$PARAM_NAME\": "

				#: determine special struts
				echo $PARAM_VALUE | grep -v grep | grep "{"
				if test $? -eq 0;
				then
					PARAMS="$PARAMS""$(read_parathesis "$PARAM_VALUE")"
				else
					echo $PARAM_VALUE | grep -v grep | grep "\["
					if test $? -eq 0;
					then
						PARAMS="$PARAMS""$(read_brackets "$PARAM_VALUE")"
					else
						#: no special struts
						PARAMS="$PARAMS""\"$PARAM_VALUE\""
					fi
				fi
				
				if (( INDEX < NUM_ARGS - 1 ));
				then
					PARAMS="$PARAMS, "
				fi

				shift 1
				(( INDEX += 1 ))
			done
			break
			;;
		*)
			usage
			;;
	esac
done

echo "-------------------------------------"
echo "Method: $LS_METHOD"
echo "Params: $PARAMS"
echo "-------------------------------------"

DATA_POSTED="{\"method\": \"$LS_METHOD\", \"params\": {$PARAMS}, \"id\": 1}"
RESULT=$(curl -X POST -H "content-type:application/json" -d "$DATA_POSTED" http://clouddata.f3322.net:10080/akso/index.php/admin/remotecontrol)
echo $RESULT

#: end of script	
