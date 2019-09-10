class Solution {
    public int findMin(int[] array) {
        if (array.length == 1) {
           return array[0];
       }

       int left = 0, right = array.length - 1, mid;

       if (array[left] < array[right]) {
           return array[left];
       }

       while (left <= right) {
           mid = (left + right) / 2;

           if (array[mid] > array[mid + 1]) {
               return array[mid + 1];
           } else if (array[mid] < array[mid - 1]) {
               return array[mid];
           }

           if (array[mid] <= array[right]) {
               right = mid - 1;
           } else {
               left = mid + 1;
           }
       }

       return -1;
    }
}