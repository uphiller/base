/*
아래는 주어진 문제를 해결하기 위한 Java 코드를 작성한 것입니다. 범위를 슬라이딩 윈도우 방식으로 탐색하여 가장 합이 큰 값을 찾아냅니다.

### **코드 설명**

1. **입력값 확인**:
   - 배열이 `null`이거나, 길이가 범위보다 짧거나, 범위가 0 이하인 경우 예외 처리.

2. **초기 합 계산**:
   - 배열의 처음부터 `range`만큼의 합을 계산하여 `currentSum` 변수에 저장.

3. **슬라이딩 윈도우**:
   - 배열을 한 칸씩 이동하며 이전 값은 빼고 새로운 값을 더함.
   - 현재 합(`currentSum`)과 최대 합(`maxSum`)을 비교하여 갱신.

4. **결과 반환**:
   - 탐색이 완료된 후 최대 합을 반환.

---

### **예시 입력 및 출력**

#### **입력**
```text
array = {2, 1, 5, 1, 3, 2}
range = 3
```

#### **출력**
```text
주어진 범위에서 가장 큰 합: 9
```

#### **과정**
- 초기 윈도우 합: \(2 + 1 + 5 = 8\)
- 슬라이딩:
  - \(8 - 2 + 1 = 7\) (인덱스 1~3)
  - \(7 - 1 + 3 = 9\) (인덱스 2~4) -> 최대값 갱신
  - \(9 - 5 + 2 = 6\) (인덱스 3~5)

최종 최대 합은 `9`.

---

### **시간 복잡도**
- 초기 합 계산: \(O(range)\)
- 슬라이딩 윈도우: \(O(n - range)\)
=> 총 시간 복잡도: \(O(n)\)

### **공간 복잡도**
- \(O(1)\): 추가 메모리 사용 없음.

이 코드는 효율적이며, 긴 배열에서도 잘 작동합니다.
 */
public class MaxSumInRange {
    public static void main(String[] args) {
        // 1차원 정수 배열과 범위 길이
        int[] array = {2, 1, 5, 1, 3, 2};
        int range = 3; // 범위의 길이

        // 최대 합을 계산하는 함수 호출
        int maxSum = findMaxSum(array, range);

        // 결과 출력
        System.out.println("주어진 범위에서 가장 큰 합: " + maxSum);
    }

    static int findMaxSum(int[] array, int range) {
        if (array == null || array.length < range || range <= 0) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
        }

        // 초기 윈도우 합 계산
        int currentSum = 0;
        for (int i = 0; i < range; i++) {
            currentSum += array[i];
        }

        int maxSum = currentSum;

        // 슬라이딩 윈도우로 합 갱신
        for (int i = range; i < array.length; i++) {
            currentSum = currentSum - array[i - range] + array[i];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}