package Hello.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Study {
    private static Integer[] append(Integer[] arr, int element) {
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));

//        array 는 고정길이 arraylist 는 가변길이 arraylist 의 default 배열 길이는 10이다

//        Integer 와 int 에 차이 int 은 자료형이다 data 의 type 에 따라 저장될 공간의 크기와 저장 형식을 정의한것 (기본형/변수의타입)
//        Integer 는 매개변수로 객체를 필요로 할 떄 / 기본형 값이 아닌 객체로 저장해야할 때 / 객체 간 비교가 필요할때
//        이런 경우 가본형을 객체로 다루기 위해 사용하는 클래스들을 래퍼클래스 라고 한다.
//        Integer 는 Int의 래퍼클래스라고 할 수 있고 모든 기본형은 래퍼클래스를 생성할 수 있다.

//        제네릭스는 선언할 수 있는 타입이 객체 타입입니다. int는 기본자료형이기 때문에 들어갈수 없으므로
//        int를 객체화시킨 wrapper클래스(Integer)를 <> 안에 사용해야 합니다
        list.add(element);
        System.out.println(list);

        return list.toArray(new Integer[0]);
//        위의 예제에서는 String 배열 인스턴스가 파라메터로 넘어갔는데, size를 '0'으로 명시했다.
//
//        1. List를 toArray 메서드에 파라메터로 넘어가는 배열 객체의 size만큼의 배열로 전환한다.
//        2. 단, 해당 List size가 인자로 넘어가는 배열 객체의 size보다 클때, 해당 List의 size로 배열이 만들어진다.
//        3. 반대로 해당 List size가 인자로 넘어가는 배열객체의 size보다 작을때는, 인자로 넘어가는 배열객체의 size로 배열이 만들어진다.
    }

    public static void main(String[] args) {
        Integer[] nums = { 1, 2, 3, 4 };

        nums = append(nums, 5);    // `nums[]`에 5를 추가합니다.
        System.out.println(Arrays.toString(nums));
    }
}

//--------------------------------------------------------------------------------------------------------


public class ClassName <T, K> {
    ...
}
/* (2) 추가 */public class Student{
    ...
}

public class Main {
    public static void main(String[] args) {
        /* (1) */ClassName<String, Integer> a = new ClassName<String, Integer>();
        /* (2) */ClassName<Student> a = new ClassName(Student)();
    }

//      <> 는 제네릭 파라미터 타입이나 리턴 타입에 대한 정의를 외부로 미룬다. >> ex) 메인 클래스에서 정의함
//      타입에 대해 유연성과 안정성 확보 / 타입에러를 컴파일전에 검출한다.
//      클래스 혹은 메소드에 선언 가능/ 동시에 여러타입 선언 가능/ 유연한 처리 가능/ 타입의 상속관계 지정 가능/
//      메소드 수행 시점에서 파라미터 타입과 비교하여 타입 전달

// (1)      위 예시대로 라면 T 는 String 이고 K 는 Integer 가 된다.
//      여기서 타입 파라미터로 명시할 수 있는 것은 참조 타입 밖에 올 수없다.

// (2)      즉 사용자가 정의한 클래스도 타입으로 올 수 있다는 것이다.

// 사용 하는 이유는 정적 메소드로 선언할 때 필요하기 때문이다.

// 근데 만약 특정 범위 내로 좁혀서 제한하고 싶은경우 extends, super, ?(와일드카드/ 알 수 없는 타입)

<K extends T>	// T와 T의 자손 타입만 가능 (K는 들어오는 타입으로 지정 됨)
<K super T>	// T와 T의 부모(조상) 타입만 가능 (K는 들어오는 타입으로 지정 됨)

<? extends T>	// T와 T의 자손 타입만 가능
<? super T>	// T와 T의 부모(조상) 타입만 가능
<?>		// 모든 타입 가능. <? extends Object>랑 같은 의미

    K extends T와 ? extends T는 비슷한 구조지만 차이점이 있다.
    '유형 경계를 지정'하는 것은 같으나 경계가 지정되고 K는 특정 타입으로 지정이 되지만,
    ?는 타입이 지정되지 않는다는 의미다.



--------------------------------------------------------------------

    War / Jar

.jar 확장자 파일에는 Class와 같은 Java 리소스와 속성 파일,  라이브러리 및 액세서리 파일이 포함되어 있다.
    쉽게 JAVA 어플리케이션이 동작할 수 있도록 자바 프로젝트를 압축한 파일로 생각하자.실제로 JAR 파일은 플랫폼에 귀속되는 점만 제외하면 WIN ZIP파일과 동일한 구조입니다.JAR 파일은 원하는 구조로 구성이 가능하며 JDK(Java Development Kit)에 포함하고 있는 JRE(Java Runtime Environment)만 가지고도 실행이 가능합니다.Student
    WAR ( Web Application Archive )
.war 확장자 파일은  servlet / jsp 컨테이너에 배치 할 수 있는 웹 어플리케이션(Web Application) 압축 파일 포맷입니다.  JSP,  SERVLET, JAR, CLASS, XML, HTML, JAVASCRIPT 등  Servlet Context 관련 파일들로 패키징 되어있다.
    WAR는 웹 응용 프로그램를 위한 포맷이기 때문에 웹 관련 자원만 포함하고 있으며 이를 사용하면 웹 어플리케이션을 쉽게 배포하고 테스트 할 수 있다.
    원하는 구성을 할 수 있는 JAR 포맷과 달리 WAR은 WEB-INF 및 META-INF 디렉토리로 사전 정의 된 구조를 사용하며 WAR파일을 실행하려면 Tomcat, Weblogic, Websphere 등의 웹 서버 (WEB)또는 웹 컨테이너(WAS)가 필요하다.


--------------------------------------------------------------------
    우리가 흔히 상수를 정의할 때 final static string 과 같은 방식으로 상수를 정의한다. 하지만 이렇게 상수를 정의해서 코딩하는 경우 다양한 문제가 발생
    1.5버전에서 추가된 것이  Enum
    Enum은 열거형이라고 불리며, 서로 연관된 상수들의 집합을 의미

    기존에 상수를 정의하는 방법이였던 final static string 과 같이 문자열이나 숫자들을 나타내는 기본자료형의 값을 enum을 이용해서 같은 효과
1. 코드가 단순해지며, 가독성이 좋아짐
2. 인스턴스 생성과 상속을 방지하여 상수값의 타입안정성이 보장
3. enum class를 사용해 새로운 상수들의 타입을 정의함으로 정의한 타입이외의 타입을 가진 데이터값을 컴파일시 체크한다.
4. 키워드 enum을 사용하기 때문에 구현의 의도가 열거임을 분명하게 알 수 있음

--------------------------------------------------------------------

loc di container

loc 프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것
Appcofig 의 등장으로 인터페이스의 다른 구현 객체를 생성하고 실행할 수 도 있다. 구현 객체는 묵묵히 자신의 로직을 실행한다.
의존관계는 정적인 클래스 의존 관계와, 실행시 결정되는 인스턴스 의존 관계 둘을 분리해서 생각해야 한다.
정적인  의존관계는 app 을 실행하지 않아도 분석 할 수 있다. 의존하는것은 알지만 어떤 객체가 주입되는지는 모른다.

클라이언트와 서버의실제 의존관계가 연결 되는 것을 의존관계 주입이라고 한다.
객체 인스턴스를 생성 > 참조값 전달 후 연결    di 를 사용하면 클라이언트 코드 변경 없이 클라이언트가 호출하는 대상의 타입 인스턴스를 변경할 수 있다.
        의존또한 의존관계를 변경하지 않고 동적인 객체 인스턴스의 의존관계를 쉽게 변경할 수 있다.
appconfig 처럼 의존관계를 연결해 주는 것을 loc 컨테이너 / di 컨테이너라고 한다 주로 di 컨테이너



