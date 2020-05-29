package jwt;

import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import com.nimbusds.jose.util.Base64URL;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import sun.security.rsa.RSAKeyPairGenerator;
import sun.security.rsa.RSAPrivateCrtKeyImpl;
import sun.security.rsa.RSAPrivateKeyImpl;
import sun.security.rsa.RSAPublicKeyImpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.text.ParseException;
import java.util.Base64;


import static org.junit.Assert.assertEquals;

/**
 * describe:
 *
 * @author syh
 * @date 2020/01/09
 */
public class JwtUtils2 {

    @Test
    public void test() throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        //
        KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA");
        rsa.initialize(512);
        KeyPair keyPair = rsa.generateKeyPair();
        PrivateKey aPrivate = keyPair.getPrivate();
        PublicKey aPublic = keyPair.getPublic();
        String out = "C:\\Users\\ken\\Desktop\\tem\\key\\private";
        String out2 = "C:\\Users\\ken\\Desktop\\tem\\key\\public";
        FileOutputStream fileOutputStream = new FileOutputStream(out);
        FileOutputStream fileOutputStream2 = new FileOutputStream(out2);
        IOUtils.write(aPrivate.getEncoded(), fileOutputStream);
        IOUtils.write(aPublic.getEncoded(), fileOutputStream2);
        fileOutputStream.close();
        fileOutputStream2.close();


    }

    @Test
    public void test2() throws JOSEException, ParseException {

        // RSA signatures require a public and private RSA key pair,
        // the public key must be made known to the JWS recipient to
        // allow the signatures to be verified
        RSAKey rsaJWK = new RSAKeyGenerator(2048).algorithm(JWEAlgorithm.RSA_OAEP_256)
                .generate();
        RSAKey rsaPublicJWK = rsaJWK.toPublicJWK();
        PrivateKey privateKey = rsaJWK.toPrivateKey();

        // Create RSA-signer with the private key
        JWSSigner signer = new RSASSASigner(privateKey);


        // Prepare JWS object with simple string as payload
        JWSObject jwsObject = new JWSObject(
                new JWSHeader.Builder(JWSAlgorithm.RS256).build(),
                new Payload("In RSA we trust!"));

        // Compute the RSA signature
        jwsObject.sign(signer);

        // To serialize to compact form, produces something like
        // eyJhbGciOiJSUzI1NiJ9.SW4gUlNBIHdlIHRydXN0IQ.IRMQENi4nJyp4er2L
        // mZq3ivwoAjqa1uUkSBKFIX7ATndFF5ivnt-m8uApHO4kfIFOrW7w2Ezmlg3Qd
        // maXlS9DhN0nUk_hGI3amEjkKd0BWYCB8vfUbUv0XGjQip78AI4z1PrFRNidm7
        // -jPDm5Iq0SZnjKjCNS5Q15fokXZc8u0A
        String s = jwsObject.serialize();
        System.out.println(s);

        // To parse the JWS and verify it, e.g. on client-side
        jwsObject = JWSObject.parse(s);

        JWSVerifier verifier = new RSASSAVerifier(rsaPublicJWK);

        //校验是否通过校验
        boolean verify = jwsObject.verify(verifier);
        System.out.println(verify);

        assertEquals("In RSA we trust!", jwsObject.getPayload().toString());

    }


}
