#include <iostream>
#include <vector>
#include <string>
#include "Command.h"

using namespace std;

int main(int argc, char** argv) {
    //Declaring variables
    vector<Command*> inputs;
    
    
    //Pushing in the command received from the bash script into the vector
    //parsing through the string
    inputs.push_back(argv,argc);
    inputs[counter->parser()];
    
    return 0;
}

