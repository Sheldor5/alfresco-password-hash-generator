package at.pali;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.System;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.util.encoders.Hex;

public class MD4HashGenerator
{

    private static final MD4Digest digest = new MD4Digest();

    public static void main (String[] args) throws Exception
    {

        String password = "";

        for (int c = 0; c < args.length; c++)
        {
            password += args[c];
            if (c+1 != args.length) {
                password += " " ;
            }
        }

        if (password != "")
        {
            System.out.println("NTLMv1 MD4 Hash of password '" + password + "' is: " + getMD4(password));
        } else
        {
            System.out.println("No password provided.");
        }

    }

    public static String getMD4(String string) throws UnsupportedEncodingException, IOException{

        byte[] r = string.getBytes("UnicodeLittleUnmarked");

        digest.update (r, 0, r.length);
        byte[] o = new byte[digest.getDigestSize()];
        digest.doFinal (o, 0);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        Hex.encode (o, ps);

        return baos.toString("UTF-8");

    }
}
