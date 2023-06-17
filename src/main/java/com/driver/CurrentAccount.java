package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId = tradeLicenseId;
        if(balance < 5000)
            throw new Exception("Insufficient Balance");
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        if(isValid(tradeLicenseId))
            return;

        String s = tradeLicenseId;
        boolean notPossible = false;

        int n = s.length();
        char[] arr = new char[n];
        for(int i=0 ; i<n ; i++)
            arr[i] = s.charAt(i);

        for(int i = 1 ; i<n ; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                int j = i;
                while(j<n && s.charAt(j) == s.charAt(i))
                    j++;
                if(j == n){
                    throw new Exception("Valid License can not be generated");
                }
                char temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        tradeLicenseId = Arrays.toString(arr);
    }


    public boolean isValid(String str){
        int n = str.length();
        for(int i = 0 ; i<n-1 ; i++){
            if(str.charAt(i) != str.charAt(i+1))
                return false;
        }
        return true;
    }
}
