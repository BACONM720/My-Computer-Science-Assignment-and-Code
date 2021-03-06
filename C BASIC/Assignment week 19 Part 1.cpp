
#include "pch.h"
#include "string.h"
#include "stdlib.h"

int readFile();
int writeFile(FILE *file);

struct result {
	char End[40];
	char Start[40];
	int age;
	char email[40];
	struct result *next; 
};
struct result *Start = NULL;
struct result *current = NULL;
struct result *End = NULL;

char rFileName[] = " C:\\Users\\Ryan9\\OneDrive\\Documents\\Documents\\users.txt";
char wFileName[] = " C:\\Users\\Ryan9\\OneDrive\\Documents\\Documents\\Bin.bin";

int main() {

	FILE *fptr0 = fopen(wFileName, "wb+");

	if (!readFile())
	{
		printf("File could'nt be opened !!\n");
		return 0;
	}

	current = Start;
	while (current != NULL)
	{
		writeFile(fptr0);
		current = current->next;
	}

	return 0;
}

int readFile() {
	char line[400];
	FILE *fptr = fopen(rFileName, "r");
	char *token;

	char delim[6] = ",";

	if (fptr == NULL) {
		printf("Error opening file ! \n");
		return 0;
	}

	// use fgets to skip first line
	fgets(line, 200, fptr);

	while (!feof(fptr)) {
		//next data line
		fgets(line, 200, fptr);

		current = (struct result*)malloc(sizeof(struct result));

		token = strtok(line, delim);
		strcpy(current->End, token);

		token = strtok(NULL, delim);
		strcpy(current->Start, token);

		token = strtok(NULL, delim);
		current->age = atoi(token);

		token = strtok(NULL, delim);
		strcpy(current->email, token);

		printf("%d\n", current->age);
		if (Start == NULL) {
			Start = current;
			End = current;
		}
		else {
			End->next = current;
			End = current;
		}
	}
	fclose(fptr);
	return 1;
}
int writeFile(FILE *file) {
	fwrite(current, sizeof(struct result), 1, file);

	return 0;
}
 