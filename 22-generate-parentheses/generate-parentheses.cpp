class Solution {
public:

    void combo( vector<string> &ans , string &curr , int n , int open , int close ){

        if( curr.size() == 2*n ){

            ans.push_back(curr);
            return;

        }


        if( open < n ){

            curr.push_back('(');
            open++;

            combo( ans , curr , n , open , close );  //recurse

            curr.pop_back();
            open--;

        }

        if( close < open ){

            curr.push_back(')');
            close++;

            combo( ans , curr , n , open , close );  //recurse

            curr.pop_back();
            close--;

            
        }

        
    }

    vector<string> generateParenthesis(int n) {

        string curr;
        vector<string> ans;
        int open = 0;
        int close = 0;

        combo( ans , curr , n , open , close );

        return ans;
        
    }
};