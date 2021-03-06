
#include "pch.h"
#include <stdio.h>
#include "string.h"


int countCharOccurence(char *string, char c);
int getOption();
int checkSpelling();
int findBestWord();

int nw = 0;
char dict[80000][35];

void main(void)
{
	FILE *Fptr;
	char fName[] = "C:\\Users\\Ryan9\\Desktop\\CT103 prog\\dict.txt";
	int option = 0;

	Fptr = fopen(fName, "r");

	if (Fptr == NULL)
	{
		printf("File could not be opened !!\n");
		return;
	}
	else
	{
		while (!feof(Fptr))
		{

			fscanf(Fptr, "%s\n", dict[nw]);
			nw++;
		}
		fclose(Fptr);
	}

	printf("%ld words read from file \n\n", nw);

	option = getOption();
	while (option != 0)
	{
		if (option == 1) checkSpelling();
		if (option == 2) findBestWord();
		if (option == 0) return;
		option = getOption();
	}
}

int getOption()
{
	int option = 0;

	puts("Menu:\n1 = check spelling:\n2 = find longest word:\n0=quit:\n");
	fflush(stdin);
	scanf("%d", &option);
	return option;
}

int checkSpelling()
{
	int i = 0;
	char place[35];

	puts("Enter word to check");
	fflush(stdin);
	gets_s(place);

	for (i = 0; i < nw; i++)
	{
		if (!strcmp(place, dict[i]))
		{
			puts("Spelling Correct!");
			return 1;
		}

		else puts("Word not found");
		return 0;
	}
}

int findBestWord()
{
	char bestFit[20];
	int numMatches = 0;
	int highestMatch = 0;
	int x = 0, y = 0, length = 0;
	char temp[20];
	int tCount = 0, wCount = 0;

	puts("Enter letters you have");

	scanf("%s", temp);

	for (x = 0; x < nw; x++)
	{
		numMatches = 0;
		length = strlen(dict[x]);

		for (y = 0; y < length; y++)
		{
			tCount = 0;
			wCount = 0;
			tCount = countCharOccurence(temp, dict[x][y]);
			wCount = countCharOccurence(dict[x], dict[x][y]);
			if ((tCount > 0) && (tCount == wCount))
			{
				numMatches = numMatches + 1;
			}
			else
			{
				numMatches = 0;
				break;
			}
		}

		if (numMatches > highestMatch)
		{
			strcpy(bestFit, dict[x]);
			highestMatch = numMatches;
		}
	}

	printf("Best Fit for \"%s\" is \"%s\"  [%d]\n", temp, bestFit, highestMatch);

	return numMatches;
}


int countCharOccurence(char *string, char c)
{
	int x = 0, count = 0, len = 0;
	len = strlen(string);
	for (x = 0; x < len; x++)
	{
		if (string[x] == c) count++;
	}
	return count;
}
