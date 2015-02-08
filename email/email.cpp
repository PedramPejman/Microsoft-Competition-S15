#include <vector>
#include <iostream>
#include <sstream>
using namespace std;


std::string hex( unsigned int c )
{
    std::ostringstream stm ;
    stm << std::hex << std::uppercase << c ;
    return stm.str() ;
}

int main()
{
    string s;
    while (cin>>s)
    {
        vector<int> ind;
        int idx_at;
        int idx_dot;
        for (int i=0;i<s.size();i++)
        {
            if ( s[i] >=33 && s[i]<=126)
                if ( s[i] >='A' && s[i] <='Z' )
                       cout<<(char)(s[i] -'A'+'a');
                else cout<<s[i];
            else 
            {
                if ( s[i] == '@' ) idx_at = i;
                else if ( s[i] == '.' ) idx_dot = i;
                else ind.push_back(i);
            }
        }
        if ( ind.size() )
        {
            for (int i=0;i<ind.size();i++)
            {
                if ( ind[i] >= idx_dot ) cout<<"+"<<ind[i] - idx_dot<<"?";
                else if ( ind[i] >= idx_at ) cout<<"+"<<ind[i] - idx_at<<"?";
                else cout<<"+"<<ind[i]<<"?";
                cout<<hex(s[ind[i]]);
            }

            cout<<"~";
            for (int i=0;i<ind.size();i++)
                cout<<s[i];
        }
        cout<<endl;
    }
}
