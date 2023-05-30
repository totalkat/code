#include <iostream>
#include <vector>
#include <iomanip> 
using namespace std;

int main(int argc, const char **args){
  int rounds;
  cin>>rounds;
  vector<int> arr;
  arr.resize(rounds);
  for(int i=0;i<rounds;i++){
    cin>>arr[i];
  }
  int i=rounds-1;
  int points =-1;
  int max = 0;
  int min=0;
  bool valid = true;
  while(i>=0) {
    if(arr[i]==-1){
      if(points ==-1){
	max++;
      }
      else{
	points--;
	if(points==0){
	  min++;
	  max++;
	  points=-1;
	}
	// cout << "i=" << i << " " << max << " " << min << " " << points << "\n";
      }
    }
    else if(arr[i]==0){
      max++;
      min++;
      if(points >0 && arr[i]+1!=points){
	// cout<<"A " <<"i=" << i <<" "<<arr[i]+1 << " " << points<<"\n";
	valid = false;
	break;
      }
      points = -1;
    }
    else{
      if(points==-1){
	points=arr[i];
      }
      else{
	if(arr[i]+1!=points){
	  // cout<<"B " <<"i=" << i <<" "<<arr[i]+1 << " " << points<<"\n";
	  valid = false;
	  break;
	}
	else{
	  points = arr[i];
	}
      }
    }
    cout << "i=" << std::setw(5) << i << " " << std::setw(5) << arr[i] << " " << std::setw(5) << points << " " << std::setw(5) << min << " " << std::setw(5) << max << "\n";
    i--;
  }
  if (valid) {
    if (min == 0) min =1;
    cout<< min << " " << max;
  }
  else
    cout << -1;
}
