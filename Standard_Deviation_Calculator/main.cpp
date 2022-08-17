/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Juan
 *
 * Created on April 16, 2021, 3:28 PM
 */

#include <cstdlib>
#include <iostream>
#include <cmath>

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    float xSubi = 0;
    float array[20];
    float x,y,z;
    for(int i = 0; i<20; i++){
        cout<<"#"<<i<<": ";
        cin>>array[i];
    }
    x = 0;
    y = 0;
    z = 0;
    for(int i = 0; i<20; i++){
        x = array[i];
        x = x*x;
        y += x;
    }
    x = 0;
    for(int i = 0; i<20; i++){
        x += array[i];
    }
    x = x*x;
    x = x/20.0f;
    z = y - x;
    z = z/19.0f;
    z = sqrt(z);
    
    cout<<endl;
    cout<<"S = "<<z;
    
    
    return 0;
}

