package com.mycompany.arrayqueue;

import java.util.NoSuchElementException;

/**
 * This class will be the arrayqueue data structure, it has the following
 * methods: add, and remove, resize is used by add and remove in order to grow
 * and shrink the array
 *
 * @author nicka
 */
public class ArrayQueueDS {

    private String[] a;//backing array
    private int j;//j is used to keep track of the next element to remove
    private int n;//number of elements 

    /**
     * default constructor, takes no parameters and initializes j and n to 0,
     * default size of the array is 10.
     */
    public ArrayQueueDS() {
        this.a = new String[10];
        this.j = 0;
        this.n = 0;
    }

    /**
     * constructor with default parameters, takes an array, j (the next element
     * to remove), and the number of total elements as parameters
     *
     * @param arr
     * @param j
     * @param n
     */
    public ArrayQueueDS(String[] arr, int j, int n) {
        this.a = arr;
        this.j = j;
        this.n = n;
    }

    /**
     * Copy constructor, takes an ArrayQueueDS object as a parameter
     *
     * @param other
     */
    public ArrayQueueDS(ArrayQueueDS other) {
        this.a = other.a;
        this.j = other.j;
        this.n = other.n;
    }
    
    /**
     * add method, takes the data to add and adds it to the back of the backing array
     * @param dataToAdd
     * @return 
     */
    public boolean add(String dataToAdd){
        if(n + 1 > a.length){//if the backing array is full then resize
            resize();
        } 
        a[(j+n) % a.length] = dataToAdd;//this is where the circular array comes in, the modulus will eventually loop back around and cause indexes to be stored in a circular manner
        n++;//increment the number of elements
        
        return true;//return true of the add is successful

    }
    
    /**
     * remove method, removes the element at index j (works like a queue, J is the "front of the line")
     * @return 
     */
    public String remove(){
        
        if(n == 0){//if the queue is empty, then throw an exception
            throw new NoSuchElementException();
        }
        String temp = a[j];//create a temp string, it is returned later
        j = (j+1) % a.length;//do the modulus on j (circular math)
        n--;//decrement the number of elements
        
        if(a.length >= 3*n){//then if a is greater than 3*n then shrink the array
            resize();
        }
        
        return temp;//return the value being removed from the queue
        
        
    }
    
    /**
     * resize method, will cause the array to grow or shrink based on which method is called.
     */
    public void resize(){
        String[] newArr = new String[max(1,n*2)];//create a new string array
        
        for(int k = 0; k < n; k++){//loop through array to copy data from old array into new array
            newArr[k] = a[(j+k) % a.length];//the copy
        }
        
        a = newArr;//then make array a equal to the new array
        j = 0;//set the next element to delete to 0
        
    }
    
    /**
     * max method, returns num1 if it is larger than num2, and returns num2 if num1 is smaller
     * @param num1
     * @param num2
     * @return 
     */
    public int max(int num1, int num2){
        if(num1 >= num2){//if num1 is bigger than num2 
            return num1;//then return num1
        } else {
            return num2;//otherwise return num2
        }
    }

}
