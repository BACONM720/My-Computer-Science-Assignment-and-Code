#include "pch.h"
#include <stdio.h>
#include "string.h"
#include "ctype.h"

void printLongestWord();

int findWord(char word[]);

/*int findWordWithMostVowels();*/

int isVowel(char c);

// generated using http://listofrandomnames.com/

char words[][20] = { " ganglioid", "causative", "uncensurable",  "daghda", "lilith", "inexcusable", "imager", "goldfish", "hderlin", "farnham" };
int nwords = 10;
char longestWord[100];


int main()
{
	char word[20];
	int i = 0;

	printLongestWord();

	/*i = findWordWithMostVowels();
	printf("Word with most vowels is: %s \n", words[i]);*/

	puts("enter word");
	gets_s(word);

	if (findWord(word))
	{
		printf("%s is in our list of words\n", word);
	}
	else
	{
		printf("%s is not in our list of words\n", word);
	}

}
void printLongestWord()
{
	int max = 0;
	char i = 0;
	int len = 0;

	for (i = 0; i < 20; i++) {
		if (strlen(words[i]) > len)
		{
			len = strlen(words[i]);
			strcpy_s(longestWord, words[i]);

		}
	}
	printf_s("longest word is: %s", &longestWord);
}


int findWord(char word[])
{
	for (int i = 0; i < 20; i++)
	{
		if (strcmp(words[i], word))
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
}

 

	/*int findWordWithMostVowels()
	{
		your code here
	}*/

	int isVowel(char c)
	{
		int numVowel[10];
		int  mostVowel = 0;

		int location;

 for (int i = 0; i < nwords; i++){
	 int counter = 0



	}
		 
	