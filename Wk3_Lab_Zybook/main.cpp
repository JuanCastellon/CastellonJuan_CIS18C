/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Juan
 *
 * Created on April 17, 2021, 7:17 PM
 */

#include <cstdlib>
#include <iostream>
using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    
    int left, right, center;
    int temp1, temp2, temp3;
    int leftSize, rightSize;
    
    cin>>left;
    cin>>right;
    
    if(left < right){
      center = left + right;
      center = center/2.0f;
    }
    
    if(left > right){
      leftSize = 4096 - left;
      rightSize = right + 1;
      temp1 = (leftSize + rightSize);
      temp1 = 0.5f*(temp1);
      cout<<"Value of center of interval = "<<temp1<<endl;
      temp2 = left;
      cout<<"Value of left = "<<temp2<<endl;
      
      for(int i = 0; i<temp1; i++){
         if(temp2 >= 4095){
            temp2 = 0;
            temp3 = 1;
         }
         if(temp2 < 4095){
            temp2++;
         }
         if(temp2 >= 0 && temp3 == 1){
             temp2++;
         }
         
      }
      center = temp2 - 1;
    }
    
    cout<<"center = "<<center<<endl;
    

    return 0;
}

