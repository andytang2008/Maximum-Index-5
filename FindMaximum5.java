import java.util.*;

class FindMaximum5{

  /* For a given array arr[],  
   returns the maximum j ¨C i such that
   arr[j] > arr[i] */
  static int maxIndexDiff(int arr[], int n)
	  {

		int []rightMax = new int[n];
		rightMax[n-1]= arr[n-1];
		System.out.println("rightMax[n-1]="+rightMax[n-1]);
		for(int i = n-2; i>=0; i--)
		  rightMax[i] = Math.max(rightMax[i+1] , arr[i]);
				System.out.println("rightMax[i] = "+Arrays.toString(rightMax));

		// rightMax[i] = max{ arr[i...(n-1] }
		int maxDist = Integer.MIN_VALUE;
		int i = 0, j = 0;
		while(i < n && j < n)
			{
			  if(rightMax[j] >= arr[i])
			  {
				maxDist = Math.max( maxDist, j-i );
				  System.out.println("  rightMax["+j+"]="+rightMax[j]+"  arr["+i+"]="+arr[i]+"  Math.max( maxDist, j-i )="+maxDist);
				j++;
			  }
			  else {// if(rightMax[j] < leftMin[i]) 
				System.out.println("  **rightMax["+j+"]="+rightMax[j]+"  arr["+i+"]="+arr[i]+"  Math.max( maxDist, j-i )="+maxDist);
				i++;
			  }
			}
		return maxDist;
	  }

  // Driver Code
  public static void main(String[] args)
  {
    int arr[] = { 9, 2, 5, 3, 6, 18, 8, 7, 0 };
	System.out.println("arr="+Arrays.toString(arr));
    int n = arr.length;
    int maxDiff = maxIndexDiff(arr, n);
    System.out.print("max Differemnce = "+maxDiff);
  }
}