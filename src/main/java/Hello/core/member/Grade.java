package Hello.core.member;

public enum Grade {
    BASIC,
    VIP
}


//    우리가 흔히 상수를 정의할 때 final static string 과 같은 방식으로 상수를 정의를합니다. 하지만 이렇게 상수를 정의해서 코딩하는 경우 다양한 문제가 발생됩니다.
//        따라서 이러한 문제점들을 보완하기 위해 자바 1.5버전부터 새롭게 추가된 것이 바로 "Enum" 입니다.
//        Enum은 열거형이라고 불리며, 서로 연관된 상수들의 집합을 의미합니다.
//        기존에 상수를 정의하는 방법이였던 final static string 과 같이 문자열이나 숫자들을 나타내는 기본자료형의 값을 enum을 이용해서 같은 효과를 낼 수 있습니다.