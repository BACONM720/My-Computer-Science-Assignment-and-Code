#include "pch.h"
#include <stdio.h>
#include "string.h"
#include "stdlib.h"

struct contact
{
	char *UserName;
	char *firstName;
	char *lastName;
	char *displayName;
	char *jobTitle;
	char *department;
	char *officeNumber;
	char *officePhone;
	char *mobilePhone;
	char *fax;
	char *address;
	char *city;
	char *state;
	char *zip;
	char *country;
	struct contact *next;
};

struct contact *first = NULL;

int readFile(char *fileName);
void printContact(struct contact *theContact);

int main()
{
	char fileName[] = "C:\\Users\\Ryan9\\Downloads\\contacts.txt";
	int i = 0;

	struct contact *current;

	if (!readFile(fileName))
	{
		printf("File could not be opened !!\n");
		return 0;
	}

	current = first;
	while (current != NULL)
	{
		printContact(current);
		current = current->next;
	}


	return 0;
}

void printContact(struct contact *theContact)
{
	printf("username: %s\n, firstname: %s\n, lastname: %s\n, display Name: %s\n, Job title: %s\n, Department: %s\n, Office NO: %s\n, Office Phone:  %s\n, Mobile Phone: %s\n, Fax %s\n, address: %s\n, City: %s\n, State: %s\n, Zip: %s\n, Country: %s\n", theContact->UserName, theContact->firstName, theContact->lastName, theContact->displayName, theContact->jobTitle, theContact->department, theContact->officeNumber, theContact->officePhone, theContact->mobilePhone, theContact->fax, theContact->address, theContact->city, theContact->state, theContact->zip, theContact->country);


}


int readFile(char *fileName)
{
	char line[400];
	FILE *fptr = fopen(fileName, "r");
	char *token;
	char delim[6] = ",";

	struct contact *last = NULL;
	struct contact *current = NULL;

	if (fptr == NULL)
	{
		printf("Error opening file ! \n");
		return 0;
	}

	// use fgets to skip first line
	fgets(line, 200, fptr);

	first = (contact*)malloc(sizeof(contact)), (char*)malloc(sizeof(token + 1));
	first->next = NULL;
	current = first;
  
	while (!feof(fptr))
	{
		fgets(line, 200, fptr);
		if (first == NULL) {
			first = (contact*)malloc(sizeof(contact)), (char*)malloc(sizeof(token + 1));
			first->next = NULL;
			current = first;
		}
		
		else {
			last = (contact*)malloc(sizeof(contact)), (char*)malloc(sizeof(token + 1));
			current->next = last;
			
			current = last;
			current->next = NULL;
		}


		token = strtok(line, delim);
		current->UserName = (char*)malloc((sizeof(token)));
		strcpy(current->UserName, token);


		token = strtok(NULL, delim);
		current->firstName = (char*)malloc((sizeof(token)));
		strcpy(current->firstName, token);


		token = strtok(NULL, delim);
		current->lastName = (char*)malloc((sizeof(token)));
		strcpy(current->lastName, token);


		token = strtok(NULL, delim);
		current->displayName = (char*)malloc((sizeof(token)));
		strcpy(current->displayName, token);


		token = strtok(NULL, delim);
		current->jobTitle = (char*)malloc((sizeof(token)));
		strcpy(current->jobTitle, token);


		token = strtok(NULL, delim);
		current->officeNumber = (char*)malloc((sizeof(token)));
		strcpy(current->officeNumber, token);


		token = strtok(NULL, delim);
		current->officePhone = (char*)malloc((sizeof(token)));
		strcpy(current->officePhone, token);


		token = strtok(NULL, delim);
		current->city = (char*)malloc((sizeof(token)));
		strcpy(current->city, token);


		token = strtok(NULL, delim);
		current->country = (char*)malloc((sizeof(token)));
		strcpy(current->country, token);


		token = strtok(NULL, delim);
		current->fax = (char*)malloc((sizeof(token)));
		strcpy(current->fax, token);


		token = strtok(NULL, delim);
		current->state = (char*)malloc((sizeof(token)));
		strcpy(current->state, token);


		token = strtok(NULL, delim);
		current->department= (char*)malloc((sizeof(token)));
		strcpy(current->department, token);


		token = strtok(NULL, delim);
		current->zip = (char*)malloc((sizeof(token)));
		strcpy(current->zip, token);


		token = strtok(NULL, delim);
		current->address = (char*)malloc((sizeof(token)));
		strcpy(current->address, token);


		token = strtok(NULL, delim);
		current->mobilePhone = (char*)malloc((sizeof(token)));
		strcpy(current->mobilePhone, token);
	
	}

	fclose(fptr);

	return 1;
}
