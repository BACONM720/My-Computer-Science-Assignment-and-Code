
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void getName(char emp[]);
int getID(char emp[]);
double getHours(char emp[]);

char firstName[40];
char surname[40];
int ID;
double hours[5];

void main()
{
	char emp1[] = "Smith,Fred,2214,,5,7,8.5,10.0.";
	char emp2[] = "Murphy,Sarah,1579,8.5,5,5,8,8.";

	getName(emp1);
	getID(emp1);
	getHours(emp1);
	printf("Employee %s %s, ID: %d, worked the following hours:\n", firstName, surname, ID);
	printf("Monday:%.2lf Tuesday:%.2lf Wednesday:%.2lf Thursday:%.2lf Friday:%.2lf \n", hours[0], hours[1], hours[2], hours[3], hours[4]);

	puts("");

	getName(emp2);
	getID(emp2);
	getHours(emp2);
	printf("Employee %s %s, ID: %d, worked the following hours:\n", firstName, surname, ID);
	printf("Monday:%.2lf Tuesday:%.2lf Wednesday:%.2lf Thursday:%.2lf Friday:%.2lf \n", hours[0], hours[1], hours[2], hours[3], hours[4]);

}


void getName(char emp[])
{
	int term = 0, lenSurname;
	for (int i = 0; i < 40; i++) {
		if (!term) {
			if (emp[i] == ',') {
				term++;
				lenSurname = i + 1;
			}
			else {
				surname[i] = emp[i];
			}

		}
		else {
			if (emp[i] == ',') break;
			firstName[i - lenSurname] = emp[i];

		}
	}
}
 
int getID(char emp[])
{
	ID = 0;
		int j = 0;
		int  jNumber = 0;
		while (jNumber!= 2)
		{
			if (emp[j] == ',')
				jNumber++;
			j++;
		}
		ID += ((int)emp[j] - 48 * 1000);
		j++;
		ID += ((int)emp[j] - 48 * 100);
		j++;
		ID += ((int)emp[j] - 48 * 10);
		j++;
		ID += ((int)emp[j] - 48);
		j++;

		return ID;

}

 

double getHours(char emp[])
{
	int index = 0;
		int loop;
	int flag = 0;
	int wholeNum = 1;
	float floatPointNum;
	int i = 0;
	

	for (loop = 0; loop < 5; loop++) {
		i++;
		wholeNum = 1;
		floatPointNum = .1;
		while ((emp[i] != ',')) && (i < strlen(emp)){
		if (emp i == ',') {
			flag = 1;
			i++;
		}
		else {
			flag = 0;
		}
		if (flag) {
			hours{ index } += (emp[i] - 48 * fracNum;
			fracNum = fracNum / 10;

		}
		else {
			hours[index] = hours[index] * wholeNum
				hours[index] += (emp[i] - 48);
			wholeNum = wholeNum * 10;
		}
		i++;

    }
index++;
	}

	int FullHoursCalc = 0;
	int total = 0;
	for (FullHoursCalc = 0; FullHoursCalc < 5; FullHoursCalc++) {
		total += hours[0];
		return total;
	}
	}
	 