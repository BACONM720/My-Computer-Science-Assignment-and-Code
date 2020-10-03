/*#include "pch.h"
#include <stdio.h>
#include <string.h>
#include <stdarg.h>
#define MAX(x,y) ((x)>(y)?(x):(y))
#define ODD(n) ((n) % 2 != 0)
#define OUT()
int Part1() {
	int i = 0;
	int j = 0;
	int k = 0;
	printf("enter a number for i: ");
	scanf("%d", &i);
	printf("enter a number for j: ");
	scanf("%d", &j);
	printf("max of %d and %d is %d\n", i, j, MAX(i, j));
	printf("enter a number for k: ");
	scanf("%d", &k);
	if (ODD(k))
	{
		printf("%d is Odd\n", k);
	}
	else
	{
		printf("%d is Even\n", k);
	}
}
*/






#include "pch.h"
#include <stdio.h>
#include <string.h>
#include <stdarg.h>
typedef enum  WashingMachine_Status { idle, washing, rinsing, spin_dry, waiting } status;

status start_washing(status currentStatus);
status wash_complete(status currentStatus);
status rinse_complete(status currentStatus);
status spinDry_complete(status currentStatus);
char getInput();
void printStatus(status currentStatus);

void Part2(void)
{
	int input = 0;

	status currentStatus = idle;

	printStatus(currentStatus);

	do
	{
		input = getInput();
		switch (input)
		{
		case 'S':
			currentStatus = start_washing(currentStatus);
			break;
		case 'W':
			currentStatus = wash_complete(currentStatus);
			break;

		case 'R':
			currentStatus = rinse_complete(currentStatus);
			break;
		case 'D':
			currentStatus = spinDry_complete(currentStatus);
			break;
		case 0:
			puts("Now Exiting...");
			break;
		default:
			puts("illegal input");
			break;
		}

		printStatus(currentStatus);

	} while (input != 0);

}

status start_washing(status currentStatus)
{
	status newStatus;

	if (currentStatus == idle)
	{
		newStatus = washing;
	}
	else
	{
		puts("error - can only start washing from idle!");
		newStatus = currentStatus;
	}

	return newStatus;
}

status wash_complete(status currentStatus)
{
	status newStatus;

	if (currentStatus == washing)
	{
		newStatus = rinsing;
	}

	else
	{
		puts("error - can only complete wash when washing!!!");
		newStatus = currentStatus;
	}

	return newStatus;
}
status rinse_complete(status currentStatus)
{
	status newStatus;

	if (currentStatus == rinsing)
	{
		newStatus = spin_dry;
	}
	
	else
	{
		puts("error - cannot complete rinsing if the washing machine is not rinsing!");
		newStatus = currentStatus;
	}

	return newStatus;
}

status spinDry_complete(status currentStatus)
{
	status newStatus;

	if (currentStatus == spin_dry)
	{
		newStatus = idle;
	}
	else
	{
		puts("error - can only complete spin_dry if the washing machine is spin-drying!");
		newStatus = currentStatus;
	}

	return newStatus;
}
char getInput()
{
	char input;

	printf("Input latest event:\n");
	printf("S - Start Washing\n");
	printf("W - Wash Complete\n");
	printf("R - Rinse Complete\n");
	printf("D - Spin-Dry Complete\n");
	printf("input: ");
	scanf("%c", &input);
	return input;
}

void printStatus(status currentStatus)
{

	switch (currentStatus)
	{
	case idle:
		printf("Current Status = IDLE\n");
		break;
	case washing:
		printf("Current Status = WASHING\n");
		break;
	case rinsing:
		printf("Current Status = RINSING\n");
		break;
	case spin_dry:
		printf("Current Status = SPIN-DRY\n");
		break;
	default:
		printf("SEVERE ERROR - CURRENT STATUS UNKNOWN");
		break;
	}

}