/*
 * package com.config.data;
 * 
 * import io.netty.channel.socket.DatagramChannel; import
 * io.netty.channel.socket.nio.NioDatagramChannel; import
 * io.netty.resolver.ResolvedAddressTypes; import
 * io.netty.resolver.dns.DnsAddressResolverGroup; import
 * io.netty.resolver.dns.DnsNameResolverBuilder; import
 * io.netty.resolver.dns.DnsServerAddressStreamProvider; import
 * io.netty.resolver.dns.DnsServerAddressStreamProviders;
 * 
 * public class DnsAddressResolverGroupFactory implements
 * AddressResolverGroupFactory {
 * 
 * @Override public DnsAddressResolverGroup create(Class<? extends
 * DatagramChannel> channelType, DnsServerAddressStreamProvider
 * nameServerProvider) { DnsAddressResolverGroup group = new
 * DnsAddressResolverGroup(new DnsNameResolverBuilder()
 * .channelType(NioDatagramChannel.class)
 * .nameServerProvider(DnsServerAddressStreamProviders.platformDefault())
 * .resolvedAddressTypes(ResolvedAddressTypes.IPV4_ONLY)); return group; }
 * 
 * }
 * 
 * 
 * Config config = new Config(); config.setAddressResolverGroupFactory(new
 * DnsAddressResolverGroupFactory()); RedissonClient client =
 * Redisson.create(config);
 * 
 */