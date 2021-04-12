using namespace std;

int reverseNum(int num)
{
    int rev = 0;

    while (num != 0)
    {
        rev = rev * 10 + num % 10;
        num /= 10;
    }

    return rev;
}

void main()
{
}