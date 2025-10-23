public class Solution 
{
    public bool HasSameDigits(string s) 
    {
        string strOriginal = s;
        while (strOriginal.Length != 2)
        {
            string str = "";
            for (int i = 0; i < strOriginal.Length - 1 ; i++)
            {
                str += (strOriginal[i] + strOriginal[i + 1]) % 10;
            }
            strOriginal = str;
        }

        if (strOriginal[0] == strOriginal[1])
            return true;
        else
            return false;
    }

}