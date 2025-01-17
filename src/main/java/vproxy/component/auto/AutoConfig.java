package vproxy.component.auto;

import vproxy.component.check.HealthCheckConfig;
import vproxy.component.elgroup.EventLoopGroup;
import vproxy.component.khala.Khala;
import vproxy.component.svrgroup.Method;
import vproxy.util.IPType;
import vproxy.util.Utils;

import java.net.InetAddress;
import java.net.SocketException;

public class AutoConfig {
    public final EventLoopGroup acceptorGroup;
    public final EventLoopGroup workerGroup;
    public final Khala khala;
    public final String nic;
    public final IPType ipType;

    public final HealthCheckConfig hcConfig;
    public final Method selectMethod;

    public final String bindAddress;
    public final InetAddress bindInetAddress;

    public AutoConfig(EventLoopGroup acceptorGroup, EventLoopGroup workerGroup,
                      Khala khala,
                      String nic, IPType ipType,
                      HealthCheckConfig hcConfig, Method selectMethod) throws SocketException {
        this.acceptorGroup = acceptorGroup;
        this.workerGroup = workerGroup;
        this.khala = khala;
        this.nic = nic;
        this.ipType = ipType;
        this.hcConfig = hcConfig;
        this.selectMethod = selectMethod;

        bindInetAddress = Utils.getInetAddressFromNic(nic, ipType);
        bindAddress = Utils.ipStr(bindInetAddress.getAddress());
    }
}
