package org.apache.hadoop.fs.aliyun.oss;

import com.aliyun.credentials.Client;
import com.aliyun.oss.common.auth.Credentials;
import com.aliyun.oss.common.auth.CredentialsProvider;
import com.aliyun.oss.common.auth.DefaultCredentials;

public class AliyunAutoCredentialsProvider implements CredentialsProvider {

    private final Client cred;

    public AliyunAutoCredentialsProvider() {
        // client would auto detect use which credentials provider,except config ak、sk by fs.oss.accessKeyId、fs.oss.accessKeySecret on core-site
        cred = new Client();
    }

    @Override
    public void setCredentials(Credentials credentials) {
    }

    @Override
    public Credentials getCredentials() {
        String ak = cred.getAccessKeyId();
        String sk = cred.getAccessKeySecret();
        String token = cred.getSecurityToken();
        return new DefaultCredentials(ak, sk, token);
    }
}
