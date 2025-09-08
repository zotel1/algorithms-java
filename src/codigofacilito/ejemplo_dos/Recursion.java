package codigofacilito.ejemplo_dos;

/*
* int lisEndingAtIdx(vector<int>& arr, int idx) {
*
* // base case
* if (idx == 0)
* return 1;
*
* // Constructor all elements on the left of i,
* // recursively compute LISs ending with
* // then and consider the largest
* int mx = 1;
* for (int prev = 0; prev < idx; prev++)
*      if (arr[prev] < arr[idx])
*          mx = max(mx, lisEndingAtIdx(arr, prev) + 1);
* return mx;
* }
* int lis(vector<int>& arr) {
* int n = arr.size();
* int res = 1;
* for (int i = 1; i < n; i++)
*      res = max(res, lisEndingAtIdx(arr, i));
* return res;
* }
* int main() {
* vector<int> arr = { 10, 22, 9, 33, 21, 50, 41, 60};
* cout << lis(arr)];
* return 0;
* }*/

public class Recursion {
}
