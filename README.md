# timeout_test_sample
외부 통신관련 time 테스트를 위한 레포지토리

## RestTemplate timeout 설정

### 1. default timeout설정
기본적으로 설정을 하지 않을 경우 기본적으로 JDK의 설정된 시간을 따른다.  
"By default, resttemplate uses timeout property from JDK installed on the machine which is always infinite in not overridden. To override the default JVM timeout, we can pass these properties during JVM start"  
>> -Dsun.net.client.defaultConnectTimeout=<TimeoutInMiliSec>  
>> -Dsun.net.client.defaultReadTimeout=<TimeoutInMiliSec>  

### 2. SimpleClientHttpRequestFactory 활용하여 설정
```java
private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
    SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();

    clientHttpRequestFactory.setConnectTimeout(CONNECT_TIMEOUT);
    clientHttpRequestFactory.setReadTimeout(READ_TIMEOUT);

    return clientHttpRequestFactory;
}
```

### 3. HttpComponentsClientHttpRequestFactory을 활용하여 설정
SimpleClientHttpRequestFactory대신 HttpComponentsClientHttpRequestFactory을 사용하여 설정이 가능하지만,
실시간 애플리케이션에서는 충분한 기능테스트가 안된 방법이다. 참고삼아 알아두자.

## RestTemplate ReadTimeout, ConnetTimeout catch 방법

```java
catch (RestClientException rce) {
    if (rce.getCaues() instanceof SocketTimeoutException) {
        rce.printStackTrace();
    }
}
```
