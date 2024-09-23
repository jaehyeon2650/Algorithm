#include <iostream>
#include <vector>
#include <cstring>
#include <algorithm>

using namespace std;

int n;
vector<int> a;
int dp[5][5][100004];

int go(int x, int y, int ind) {
    if (ind == n) return 0;
    if (dp[x][y][ind] != -1) return dp[x][y][ind];
    
    int ret = 123456789;
    int nextStep = a[ind];
    
    if (x == 0) ret = min(ret, go(nextStep, y, ind + 1) + 2);
    else if (x == nextStep) ret = min(go(nextStep, y, ind + 1) + 1, ret);
    else if (abs(x - nextStep) == 2) ret = min(go(nextStep, y, ind + 1) + 4, ret);
    else ret = min(go(nextStep, y, ind + 1) + 3, ret);

    if (y == 0) ret = min(ret, go(x, nextStep, ind + 1) + 2);
    else if (y == nextStep) ret = min(go(x, nextStep, ind + 1) + 1, ret);
    else if (abs(y - nextStep) == 2) ret = min(go(x, nextStep, ind + 1) + 4, ret);
    else ret = min(go(x, nextStep, ind + 1) + 3, ret);
    
    return dp[x][y][ind] = ret;
}

int main() {
    memset(dp, -1, sizeof(dp));
    
    string s;
    getline(cin, s);
    
    vector<string> tokens;
    string token;
    for (char ch : s) {
        if (ch == ' ') {
            tokens.push_back(token);
            token = "";
        } else {
            token += ch;
        }
    }
    if (!token.empty()) tokens.push_back(token);
    
    n = tokens.size() - 1;
    a.resize(n);
    
    for (int i = 0; i < n; ++i) {
        a[i] = stoi(tokens[i]);
    }
    
    cout << go(0, 0, 0) << endl;
    
    return 0;
}
