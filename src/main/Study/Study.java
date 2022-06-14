package Hello.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Study {
    private static Integer[] append(Integer[] arr, int element) {
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
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

