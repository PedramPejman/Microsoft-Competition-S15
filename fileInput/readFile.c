#include <stdlib.h>
#include <stdio.h>

int main(int argc, char **argv) {
  FILE * fp = fopen("input.txt", "r");
  if (!fp) {
    printf("File not Found\n");
    exit(1);
  }
  int len = 0;
  char **contents = (char **) malloc(1024 * sizeof(char*));
  while ( !feof(fp) && len < 1024) {
    contents[len] = (char *) malloc(1024 * sizeof(char));
    fscanf(fp, "%s", contents[len++]);
  }
  fclose(fp);
  

  int i;
  for ( i = 0; i < len - 1; i++ ) printf("%s, ", contents[i]);
  printf("%s\n", contents[i]);

  int k;
  for ( k = 0; k < len; k++ ) free(contents[k]);
  free(contents);

}
