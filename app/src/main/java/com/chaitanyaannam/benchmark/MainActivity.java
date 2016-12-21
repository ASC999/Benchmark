package com.chaitanyaannam.benchmark;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.GridLayout;
        import android.widget.GridView;
        import android.widget.TextView;

class Mainactivity extends AppCompatActivity {

    private EditText etArraySize;
    private TextView tvResult1;
    private TextView tvBubbleSort;
    private GridLayout gLayout;
    private TextView tvInsertionSort;
    private TextView tvSelectionSort;
    private TextView tvQuickSort;
    private TextView tvMergeSort;
    private TextView tvHeapSort;
    private Button btnBubbleSort;
    private Button btnInsertionSort;
    private Button btnSelectionSort;
    private Button btnMergeSort;
    private Button btnQuickSort;
    private Button btnHeapSort;
    private Button btnBenchmarkAll;
    private static int caseNo = 2;
    private static int arraySize;
    private static int[] array;


    public void arrayCase(View View) {
        switch(View.getId()) {
            case R.id.rbBestCase:
                caseNo = 1;
                break;
            case R.id.rbAverageCase:
                caseNo = 2;
                break;
            case R.id.rbWorstCase:
                caseNo = 3;
                break;
        }
    }

    public void generateArray(View View) {
        arraySize = 0;
        try{
            arraySize = Integer.parseInt(etArraySize.getText().toString());
            gLayout.setVisibility(View.VISIBLE);
        } catch (NumberFormatException e) {
            tvResult1.setText("Please Enter a Valid Array Size...");
            return;
        }

        array = new int[arraySize];
        switch(caseNo) {

            case 1:
                for (int i=0; i<array.length; i++)
                    array[i] = i+1;
                tvResult1.setText("An Array of size "+arraySize+" is generated for Best Case.");
                break;
            case 2:
                for (int i=0; i<array.length; i++)
                    array[i] = (int) (Math.random()*1000);
                tvResult1.setText("An Array of size "+arraySize+" is generated for Average Case.");
                break;
            case 3:
                for (int i=0; i<array.length; i++)
                    array[i] = array.length-i;
                tvResult1.setText("An Array of size "+arraySize+" is generated for Worst Case.");
                break;
        }

    }

    public void bubbleSort(int[] array) {

        int temp;
        for (int i=0; i<array.length; i++) {
            for (int j=1; j<(array.length-i); j++) {
                if (array[j-1]>array[j]) {
                    temp = array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }
            }
        }
    }

    public void selectionSort(int[] array) {
        for (int i=0; i<array.length; i++) {
            int index = i;
            for (int j=i+1; j<array.length; j++) {
                if (array[j] < array[index])
                    index = j;
            }
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
    }

    public void insertionSort(int[] array) {
        for (int j = 1; j < (array.length-1); j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
    }


    public void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        int i = low, j = high;
        while (i <= j) {

            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(arr, low, j);
        if (high > i)
            quickSort(arr, i, high);
    }

    private void heapify(int i, int[] data, int size) {
        int largestElementIndex = i;

        int leftChildIndex = (2*i+1);
        if (leftChildIndex < size && data[leftChildIndex] > data[largestElementIndex])
            largestElementIndex = leftChildIndex;

        int rightChildIndex = (2*i+2);
        if (rightChildIndex < size && data[rightChildIndex] > data[largestElementIndex])
            largestElementIndex = rightChildIndex;

        if (largestElementIndex != i) {
            int swap = data[i];
            data[i] = data[largestElementIndex];
            data[largestElementIndex] = swap;

            heapify(largestElementIndex, data, size);
        }
    }

    public void heapSort(int data[]) {
        int size = data.length;

        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(i, data, size);

        for(int i=data.length-1;i>=0;i--){
            int temp = data[0];
            data[0]=data[i];
            data[i]=temp;

            size  = size-1;

            heapify(0, data, size);
        }
    }

    public void complexityMergeSort(View View) {
        btnBubbleSort.setClickable(false);
        btnInsertionSort.setClickable(false);
        btnSelectionSort.setClickable(false);
        // btnMergeSort.setClickable(false);
        btnQuickSort.setClickable(false);
        btnHeapSort.setClickable(false);
        btnBenchmarkAll.setClickable(false);
        int[] array1 = array.clone();
        long start = System.currentTimeMillis();
        bubbleSort(array1);
        long end = System.currentTimeMillis();
        tvMergeSort.setText(""+(end-start)+" ms");
    }



    public void complexityBubbleSort(View View) {
        //btnBubbleSort.setClickable(false);
        btnInsertionSort.setClickable(false);
        btnSelectionSort.setClickable(false);
        btnMergeSort.setClickable(false);
        btnQuickSort.setClickable(false);
        btnHeapSort.setClickable(false);
        btnBenchmarkAll.setClickable(false);
        int[] array1 = array.clone();
        long start = System.currentTimeMillis();
        bubbleSort(array1);
        long end = System.currentTimeMillis();
        tvBubbleSort.setText(""+(end-start)+" ms");
    }

    public void complexitySelectionSort(View View) {
        btnBubbleSort.setClickable(false);
        btnInsertionSort.setClickable(false);
        //btnSelectionSort.setClickable(false);
        btnMergeSort.setClickable(false);
        btnQuickSort.setClickable(false);
        btnHeapSort.setClickable(false);
        btnBenchmarkAll.setClickable(false);
        int[] array2 = array.clone();
        long start = System.currentTimeMillis();
        selectionSort(array2);
        long end = System.currentTimeMillis();
        tvSelectionSort.setText(""+(end-start)+" ms");
    }

    public void complexityInsertionSort(View View) {
        btnBubbleSort.setClickable(false);
        // btnInsertionSort.setClickable(false);
        btnSelectionSort.setClickable(false);
        btnMergeSort.setClickable(false);
        btnQuickSort.setClickable(false);
        btnHeapSort.setClickable(false);
        btnBenchmarkAll.setClickable(false);
        int[] array3 = array.clone();
        long start = System.currentTimeMillis();
        insertionSort(array3);
        long end = System.currentTimeMillis();
        tvInsertionSort.setText(""+(end-start)+" ms");
    }



    public void complexityQuickSort(View View) {
        btnBubbleSort.setClickable(false);
        btnInsertionSort.setClickable(false);
        btnSelectionSort.setClickable(false);
        btnMergeSort.setClickable(false);
        // btnQuickSort.setClickable(false);
        btnHeapSort.setClickable(false);
        btnBenchmarkAll.setClickable(false);
        int[] array5 = array.clone();
        long start = System.currentTimeMillis();
        quickSort(array5,0,array5.length-1);
        long end = System.currentTimeMillis();
        tvQuickSort.setText(""+(end-start)+" ms");
    }

    public void complexityHeapSort(View View) {
        btnBubbleSort.setClickable(false);
        btnInsertionSort.setClickable(false);
        btnSelectionSort.setClickable(false);
        btnMergeSort.setClickable(false);
        btnQuickSort.setClickable(false);
        // btnHeapSort.setClickable(false);
        btnBenchmarkAll.setClickable(false);
        int[] array6 = array.clone();
        long start = System.currentTimeMillis();
        heapSort(array6);
        long end = System.currentTimeMillis();
        tvHeapSort.setText(""+(end-start)+" ms");
    }

    public void benchmarkAll(View View) {
        btnBubbleSort.setClickable(false);
        btnInsertionSort.setClickable(false);
        btnSelectionSort.setClickable(false);
        btnMergeSort.setClickable(false);
        btnQuickSort.setClickable(false);
        btnHeapSort.setClickable(false);
        //btnBenchmarkAll.setClickable(false);
        complexityBubbleSort(View);
        complexitySelectionSort(View);
        complexityInsertionSort(View);
        complexityQuickSort(View);
        complexityHeapSort(View);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algo_benchmark_layout);
        etArraySize = (EditText) findViewById(R.id.etArraySize);
        tvResult1 = (TextView) findViewById(R.id.tvResult1);
        tvBubbleSort = (TextView) findViewById(R.id.tvBubbleSort);
        tvInsertionSort = (TextView) findViewById(R.id.tvInsertionSort);
        tvSelectionSort = (TextView) findViewById(R.id.tvSelectionSort);
        tvQuickSort = (TextView) findViewById(R.id.tvQuickSort);
        tvMergeSort = (TextView) findViewById(R.id.tvMergeSort);
        tvHeapSort = (TextView) findViewById(R.id.tvHeapSort);
        gLayout = (GridLayout) findViewById(R.id.gLayout);
        btnBubbleSort = (Button) findViewById(R.id.btnBubbleSort);
        btnInsertionSort = (Button) findViewById(R.id.btnInsertionSort);
        btnSelectionSort = (Button) findViewById(R.id.btnSelectionSort);
        btnMergeSort = (Button) findViewById(R.id.btnMergeSort);
        btnQuickSort = (Button) findViewById(R.id.btnQuickSort);
        btnHeapSort = (Button) findViewById(R.id.btnHeapSort);
        btnBenchmarkAll = (Button) findViewById(R.id.btnBenchmarkAll);

    }
}
