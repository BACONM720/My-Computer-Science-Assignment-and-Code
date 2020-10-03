
#include "pch.h"
#include <stdio.h>
#include <string.h>
#define MAX(x,y) ((x)>(y)?(x):(y))
#define ODD(n) ((n) % 2 != 0)
#define OUT(x) (#x)

typedef enum  WashingMachine_Status { idle, washing, rinsing, spin_dry, waiting } status;

status start_washing(status currentStatus);
status wash_complete(status currentStatus);
status rinse_complete(status currentStatus);
status spinDry_complete(status currentStatus);
char getInput();
void printStatus(status currentStatus);
int part1();
void main(void)
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
		case 'E':
			part1();
			break;
		case 0:
			printf("Now Exiting...");
			break;
		default:
			puts("illegal input");
			break;
		}

		printStatus(currentStatus);

	} while (input != 0);

}
 

int part1() {
	int i = 0;
	int j = 0;
	int k = 0;

	printf("\nenter a number for i: ");
	scanf("%d", &i);
	printf("\nenter a number for j: ");
	scanf("%d", &j);
	printf("\nmax of %d and %d is %d\n", i, j, MAX(i, j));
	
	printf("\n%s\n", OUT(10.456536));
	printf("\n%s\n", OUT(Nerds));
	printf("\n%s\n\n", OUT(OUTPUT YALL));

	printf("\n enter a number for k: ");
	scanf("%d", &k);

	if (ODD(k))
	{
		printf("%d is Odd\n\n\n", k);
		return 1;
		getchar();
	}
	else
	{
		printf("%d is Even\n\n\n", k);
		return 1;
		getchar();
	}
	return 1;
	getchar();
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
	char input[10];

	printf("Input latest event:\n\n");
	printf("S - Start Washing\n\n");
	printf("W - Wash Complete\n\n");
	printf("R - Rinse Complete\n\n");
	printf("D - Spin-Dry Complete\n\n");
	printf("E - Exit and do part 1 of assignment\n\n");
	printf("input: ");
	gets_s(input);
	return input[0];
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