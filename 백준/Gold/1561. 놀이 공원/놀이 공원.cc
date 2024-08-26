#include <bits/stdc++.h>
using namespace std;

long long n;
int m;
long long maxn = numeric_limits<long long>::max();
long long maxnMin = numeric_limits<long long>::min();
vector<long long> arr;

void go(long long start, long long end);
bool check(long long index);

int main() {
    cin >> n >> m;
    arr.resize(m);
    for (int i = 0; i < m; i++) {
        cin >> arr[i];
        maxnMin = max(maxnMin, arr[i] * n);
    }
    go(1LL, maxnMin);
    int index = 0;
    long long total = 0;
    for (int i = 0; i < m; i++) {
        long long num = (maxn - 1) / arr[i];
        if ((maxn - 1) % arr[i] > 0) {
            num++;
        }
        total += num;
    }
    for (int i = 0; i < m; i++) {
        long long cur = arr[i];
        if (total == n) break;
        if (cur == 1LL) {
            index = i;
            total++;
        }
        else {
            if (maxn % cur == 1) {
                index = i;
                total++;
            }
        }
    }
    cout << index + 1 << endl;
    return 0;
}

void go(long long start, long long end) {
    while (start <= end) {
        long long index = (start + end) / 2;
        if (check(index)) {
            maxn = min(maxn, index);
            end = index - 1;
        }
        else {
            start = index + 1;
        }
    }
}

bool check(long long index) {
    long long total = 0;
    for (int i = 0; i < m; i++) {
        long long count = index / arr[i];
        if (index % arr[i] > 0) {
            count++;
        }
        total += count;
    }
    return total >= n;
}
