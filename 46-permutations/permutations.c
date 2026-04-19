#include <stdlib.h>

/* Helper to copy an array */
static int* copyArray(int *src, int n){
    int *dst = (int*)malloc(n * sizeof(int));
    for (int i = 0; i < n; ++i) dst[i] = src[i];
    return dst;
}

/* Backtracking to generate permutations */
static void backtrack(int *nums, int n, int *used, int *current, int depth,
                      int ***res, int *returnSize, int **returnColumnSizes) {
    if (depth == n) {
        (*res)[*returnSize] = copyArray(current, n);
        (*returnColumnSizes)[*returnSize] = n;
        (*returnSize)++;
        return;
    }
    for (int i = 0; i < n; ++i) {
        if (used[i]) continue;
        used[i] = 1;
        current[depth] = nums[i];
        backtrack(nums, n, used, current, depth + 1, res, returnSize, returnColumnSizes);
        used[i] = 0;
    }
}

/* nums: input array, numsSize: length
   returnSize: pointer to number of permutations
   returnColumnSizes: pointer to array of column sizes (each equals numsSize)
   Caller is responsible for freeing returned array and each row and returnColumnSizes.
*/
int** permute(int* nums, int numsSize, int* returnSize, int** returnColumnSizes){
    int maxPerms = 1;
    for (int i = 2; i <= numsSize; ++i) maxPerms *= i;

    int **res = (int**)malloc(maxPerms * sizeof(int*));
    *returnColumnSizes = (int*)malloc(maxPerms * sizeof(int));
    *returnSize = 0;

    int *used = (int*)calloc(numsSize, sizeof(int));
    int *current = (int*)malloc(numsSize * sizeof(int));

    backtrack(nums, numsSize, used, current, 0, &res, returnSize, returnColumnSizes);

    free(used);
    free(current);

    return res;
}
