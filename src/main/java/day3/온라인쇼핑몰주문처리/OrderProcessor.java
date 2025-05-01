package day3.온라인쇼핑몰주문처리;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderProcessor {
    public static void main(String[] args) {
        // 샘플 주문 데이터 생성
        List<Order> orders = getOrders();

        // 1. 총 주문 금액 계산
        // flatMap을 사용해서 모든 주문에 포함된 상품들을 하나의 스트림으로 변환한 후 가격 합계 계산
        double sumPrice = orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.println(sumPrice);


        // 2. 카테고리별 판매 금액 집계
        // flatMap, grouping by, summingDouble
        Map<String, Double> sumPriceByCategory = orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(Product::getPrice)));

        System.out.println(sumPriceByCategory);


        // 3. 최근 24시간 내 주문 필터링
        List<Order> recentOrder = orders.stream()
                .filter(order -> order.getOrderDate().isAfter(LocalDateTime.now().minusHours(24)))
                .toList();

        System.out.println(recentOrder);

        // 4. 고객별 주문 횟수 및 총 금액 집계 (추가 예제)

//        orders.stream()
//                .flatMap(order -> order.getProducts().stream())
//                .collect(Collectors.groupingBy(Order::getCustomerName, Collectors.summingDouble(Product::getPrice)));

    }

    private static List<Order> getOrders() {
        // 현재 시간과 이전 시간 데이터 준비
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterdayTime = now.minusDays(2);

        // 다양한 카테고리의 상품 생성
        Product laptop = new Product("노트북", 1_200_000, "전자제품");
        Product phone = new Product("스마트폰", 800_000, "전자제품");
        Product book = new Product("자바 프로그래밍", 30_000, "도서");
        Product chair = new Product("사무용 의자", 150_000, "가구");
        Product desk = new Product("책상", 200_000, "가구");

        // 여러 주문 생성
        return List.of(
                new Order("ORD001", "김철수", List.of(laptop, chair), now),
                new Order("ORD002", "이영희", List.of(phone, book), now),
                new Order("ORD003", "박지민", List.of(desk), yesterdayTime),
                new Order("ORD004", "김철수", List.of(book, book), now.minusHours(6))
        );
    }
}
