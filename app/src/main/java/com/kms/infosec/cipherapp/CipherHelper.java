package com.kms.infosec.cipherapp;

public class CipherHelper {

	int keylength = 0;
    String key = "";
	String cipherTable = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	//constructor to create the CipherHelper instance
	CipherHelper(String keyInput) {
        String keyInputArr[] = keyInput.split(" ");
		this.key = keyInputArr[0].toUpperCase();
        keylength = this.key.length();
	}

	public String doCipher(String inputStr) {
		String textOut = "";
		inputStr = inputStr.toUpperCase();
		int charCount = 0;
		for (int itr = 0; itr < inputStr.length(); itr++)
			{
				if (inputStr.charAt(itr) == ' ')
					{
						textOut = textOut + " ";
					} else if (!(cipherTable.contains("" + inputStr.charAt(itr))))
					{
						textOut = textOut + inputStr.charAt(itr);
					}

				else
					{

						int keyPos = charCount % keylength;
                        int charPos = cipherTable.indexOf(inputStr.charAt(itr));
						int cipherTabPos = cipherTable.indexOf(key.charAt(keyPos))
								+ charPos;
						textOut = textOut + cipherTable.charAt(cipherTabPos%cipherTable.length());
						charCount ++;
					}
			}

		return textOut;
	}
	
	
	public String doDecipher(String inputStr) {
		String textOut = "";
		inputStr = inputStr.toUpperCase();
		int charCount = 0;
		for (int itr = 0; itr < inputStr.length(); itr++)
			{
				if (inputStr.charAt(itr) == ' ')
					{
						textOut = textOut + " ";
					} else if (!(cipherTable.contains("" + inputStr.charAt(itr))))
					{
						textOut = textOut + inputStr.charAt(itr);
					}

				else
				{
						int keyPos = charCount % keylength;
						int charPos = cipherTable.indexOf(key.charAt(keyPos));
						int cipherTabPos = cipherTable.indexOf(inputStr.charAt(itr))
								- charPos;
						if (cipherTabPos < 0) cipherTabPos=cipherTabPos+36;
						textOut = textOut + cipherTable.charAt(cipherTabPos%36);
						charCount ++;
					}
			}
		return textOut;
	}

}