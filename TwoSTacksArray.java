import java.util.*;

public class TwoStacksArray<T extends Number>{
    private static int topA, topB, size;
private T[] arr;


public TwoStacksArray(int n){
    topA  = -1;
    topB  = -1;
    size  = n;
    arr = (T[])(new Number[size]);
}

public int topA(){
    System.out.println( "Top A is_______" + topA);
    return topA;
}

public int topB(){
    System.out.println( "Top B is_______" + topB);

    return topB;
}


public static boolean isEmptyA(){
    return topA == -1;
}

public static boolean isEmptyB(){
    return topB == -1;
}

public boolean isFull(){
    return topA + 1 == topB;
}



public void pushA(T entry){
    if(isFull()){
        System.out.println("Stack overflow. Array is full");
}
    else {
        topA = topA + 1 ;
        arr[topA] = entry;
        System.out.println("Top A is_______" + topA);
    }
}


public void pushB(T entry){
    if(isFull()){
        System.out.println("Stack Overflow");
    
        
    }

    else if(isEmptyB()){
        topB = size -1;
        arr[topB] = entry;
    }
    else{
          topB --;
          arr[topB] = entry;
    }
}


public T popA(){
    if(isEmptyA()){
        System.out.println("Stack underflow");
        return null;
    }
    else{
        T entry =  arr[topA];
        topA --;
        return entry;
    }
    

}


public T popB(){
    if(isEmptyB()){
        System.out.println("Stack underflow");
        System.exit(1);
        return null;
    }
    else if(topB == size - 1){
        T element = arr[topB];
        topB = -1;
        return element;
}
    else{
        T element = arr[topB];
        topB ++;
        return element;
    }
}



public static void main(String args[]){

    TwoStacksArray myTwoStackArray = new TwoStacksArray<Number>(20);
    myTwoStackArray.topA();
    myTwoStackArray.topB();
    myTwoStackArray.pushA(3);
    myTwoStackArray.topA();
    System.out.println("TOP A SHOULD BE 0");
    
    System.out.println("----------------------------------------");
    myTwoStackArray.pushB(5);
    myTwoStackArray.topB();
    System.out.println("TOP B SHOULD BE 19");
    myTwoStackArray.pushA(8);
    myTwoStackArray.pushA(4);
    myTwoStackArray.pushA(31);
    myTwoStackArray.pushA(46);
    myTwoStackArray.topA();
    System.out.println("TOP A SHOULD BE 4");
    
    System.out.println("----------------------------------------");
    myTwoStackArray.pushB(8);
    myTwoStackArray.pushB(4);
    myTwoStackArray.pushB(31);
    myTwoStackArray.pushB(46);
    myTwoStackArray.topB();
    System.out.println("TOP B SHOULD BE 15");
    
    System.out.println("----------------------------------------");
    myTwoStackArray.pushB(233);
    myTwoStackArray.pushB(433);
    myTwoStackArray.pushB(888);
    myTwoStackArray.pushB(463);
    myTwoStackArray.topB();
    System.out.println("TOP B SHOULD BE 11");

    System.out.println("----------------------------------------");
    myTwoStackArray.pushA(233);
    myTwoStackArray.pushA(433);
    myTwoStackArray.pushA(888);
    myTwoStackArray.pushA(463);
    myTwoStackArray.topA();
    System.out.println("TOP B SHOULD BE 8");
    
    System.out.println("----------------------------------------");
    myTwoStackArray.pushA(233);
    myTwoStackArray.pushA(433);
    myTwoStackArray.pushA(888);
    System.out.println("There should be stack overflow");
    System.out.println("----------------------------------------");
    myTwoStackArray.popB();
    myTwoStackArray.topB();
    System.out.println("TOP B SHOULD BE 12");
    
    System.out.println("----------------------------------------");
    myTwoStackArray.popA();
    myTwoStackArray.topA();
    System.out.println("TOP A SHOULD BE 9");
    
    while(!isEmptyB()){
        myTwoStackArray.popB();
        myTwoStackArray.topB();
    }
    myTwoStackArray.popB();
    
    
    System.out.println("----------------------------------------");
    while(!isEmptyA()){
        myTwoStackArray.popA();
        myTwoStackArray.topA();
    }
    myTwoStackArray.popA();
}
    
    


}