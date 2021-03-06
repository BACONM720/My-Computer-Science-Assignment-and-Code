#include "pch.h"
#include <stdio.h>
#include <math.h>
#include "string.h"
#include "stdlib.h"
#include <time.h>
struct date
{
	int day, month, year;
};

struct customer
{
	char name[50];
	int accountNumber;
	double balance;
	struct date lastTrans;
};

int getDay(int month);
int getMonth();
int getYear();
double getBalance();

void printCustomers(struct customer customers[], int nCustomers);
void populateCustomers(struct customer customers[], int nCustomers);
int transaction(struct customer customers[], int accountNumber, double amount, int nCustomers);

int main()
{
	int i;

	struct customer customers[10];

	populateCustomers(customers, 10);

	printf_s("%25s\t%13s\t%12s\t%s\n\n", "Name", "Account Number", "Balance", "Date of Last Transaction");

	printCustomers(customers, 10);

	printf_s("\n\n");

	if (!(transaction(customers, 10001, -967.89, 10)))
	{
		printf_s("account number %d not found - transaction cancelled", 10001);
	}
	else
	{
		printf_s("account number %d - transaction processed", 10001);
	}
	printf_s("\n\n");

	if (!(transaction(customers, 33, -967.89, 10)))
	{
		printf_s("account number %d not found - transaction cancelled", 33);
	}
	else
	{
		printf_s("account number %d  - transaction processed", 33);
	}
	printf_s("\n\n");

	printf_s("%25s\t%13s\t%12s\t%s\n\n", "Name", "Account Number", "Balance", "Date of Last Transaction");

	printCustomers(customers, 10);

	printf_s("\n\n");

	return 0;
}

int getDay(int month)
{
	int day=0, max = 31;

	if (month == 2)
	{
		day = (rand() % 28) + 1;
	}
	else if (month == 4)
	{
		day = (rand() % 30) + 1;
	}
	else if (month == 6)
	{
		day = (rand() % 30) + 1;
	}
	else if (month == 9)
	{
		day = (rand() % 30) + 1;
	}
	else if (month == 11)
	{
		day = (rand() % 30) + 1;
	}
	else
	{
		day = (rand() % 31 + 1)
	}
	return day;
}


int getMonth()
{
 
	int month; month = rand() % 12 + 1;
	return month;
}

int getYear()
{
 
	int year; year = rand() % 4 + 2013;
	return year;
}

double getBalance()
{ 
	double balance = ((rand() % 10000) + 1);
	if (balance > 5000 && balance < 10000) balance = (balance - 5000) * -1;
	return balance;

}

void printCustomers(struct customer customers[], int nCustomers)
{
	int i;

	 
	for (i = 0; i < nCustomers; i++) {
		printf_s("%25s\t%13d\t%12.2lf\t%d/%d/%d/\n\n", customers[i].name, customers[i].accountNumber, customers[i].balance, customers[i].lastTrans.day, customers[i].lastTrans.month, customers[i].lastTrans.year);
	}
	return;
}

void populateCustomers(struct customer customers[], int nCustomers)
{
	int i;
	char names[10][50] = { "Haiden Soto","Oscar Hernandez","Heath Hickman","Reagan Mcknight","Noah Bartlett","Ross Day","Maribel Livingston","Jewel Phillips","Blake Gardner","Fernanda Ponce" };

	for (i = 0; i < nCustomers; i++)
	{
		strcpy_s(customers[i].name,sizeof(names[i]), names[i]);
		customers[i].accountNumber = 10000 + i;
		
		customers[i].lastTrans.month = getMonth();
		customers[i].lastTrans.day = getDay(customers[i].lastTrans.month);
		customers[i].lastTrans.year = getYear();
		customers[i].balance = getBalance();
		 
	}

	return;

}

int transaction(struct customer customers[], int accountNumber, double amount, int nCustomers)
{
	int i;


	for (i = 0; i < nCustomers; i++)
	{
		if (customers[i].accountNumber == accountNumber) {
			customers[i].balance += amount;
			return 1;
		}
	}

	return 0;
}
