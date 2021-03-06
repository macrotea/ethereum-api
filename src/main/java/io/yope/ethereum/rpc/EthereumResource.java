package io.yope.ethereum.rpc;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
public class EthereumResource {

    private JsonRpcHttpClient client;
    private EthereumRpc ethereumRpc;


    public EthereumResource(final String ethereumURL) throws MalformedURLException {
        this.client = new JsonRpcHttpClient(new URL(ethereumURL));
    }

    public EthereumRpc getGethRpc() {
        if (ethereumRpc == null) {
            this.ethereumRpc =
                    ProxyUtil.createClientProxy(getClass().getClassLoader(), EthereumRpc.class, client);
        }
        return this.ethereumRpc;
    }
}
