import java.util.Scanner;

//스마트폰 인터페이스
interface smartphone{
    public String getName();//기종 이름 접근 메서드
    public int getPrice();//가격 접근 메서드
    void sell();//판매 문구 출력 메서드
}

//스마트폰 인터페이스 상속한 아이폰 클래스
class iphone implements smartphone{
    
    //은닉화
    private String name;
    private int price;

    //기종 접근 메서드
    public void setName(String name){
        this.name= name;
    }
    //가격 접근 메서드
    public void setPrice(int price){
        this.price = price;
    }

    //기종 값 반환 메서드
    public String getName(){
        return name;
    }

    //가격 값 반환 메서드
    public int getPrice(){
        return price;
    }

    //메뉴 보여주는 메서드
    public void menu(){
        System.out.println("1.iphone8(20만원)");
        System.out.println("2.iphone8+(30만원)");
        System.out.println("3.ipadpro11(40만원)");
        System.out.println("4.iphone11(50만원)");
    }

    //판매 문구 출력 메서드
    public void sell(){
        System.out.println(getName()+" 판매되었습니다.");
    }
}

//스마트폰 인터페이스 상속한 안드로이드 클래스
class android implements smartphone{
    private String name;
    private int price;

    public void setName(String name){
        this.name= name;
    }
    public void setPrice(int price){
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public void menu(){
        System.out.println("1.galaxys8(20만원)");
        System.out.println("2.galaxys8+(30만원)");
        System.out.println("3.galaxynote9(40만원)");
        System.out.println("4.galaxynote10(50만원)");
    }

    public void sell(){
        System.out.println(getName()+" 판매되었습니다.");
    }
}

class Main {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("안드로이드와 아이폰 중 하나를 고르시오!(android,iphone 중 하나 입력)");
        
        //폰 종류 입력
        String choice = scan.next();

        //폰 종류가 아이폰과 같을시(equals 함수로 같은 값인지 비교, '==' 비교연산자는 동적으로 값을 받을 경우 false처리함.)
        if(choice.equals("iphone")){
            iphone ip1 = new iphone();//아이폰 객체 생성
            System.out.println("소유하고 계시는 금액을 입력하세요");
            //소지하고 있는 값 정수형태로 입력
            int havePrice = scan.nextInt();

            //입력한 값을 set메서드를 통해 은닉화된 변수에 접근 및 저장
            ip1.setPrice(havePrice);
            
            //소지 금액이 20만원 이상일시
            if(havePrice>=200000){
                //메뉴판 출력
                ip1.menu();

                System.out.println("원하는 기종을 입력하시오.");
                //원하는 기종 입력
                String wantType = scan.next();

                //입력한 값을 set메서드를 통해 은닉화된 변수에 접근 및 저장
                ip1.setName(wantType);
                
                //입력한 값이 아이폰8이고 입력값이 20만 이상일 경우
                if(wantType.equals("iphone8")&&(havePrice>=200000)){
                    //아이폰8 판매 문구 출력
                    ip1.sell();
                }

                else if(wantType.equals("iphone8+")&&(havePrice>=300000)){
                    ip1.sell();
                }

                else if(wantType.equals("ipadpro")&&(havePrice>=400000)){
                    ip1.sell();
                }

                else if(wantType.equals("iphone11")&&(havePrice>=500000)){
                    ip1.sell();
                }

                else{
                    System.out.println("금액 부족입니다. 금액 내에서 골라주세요ㅠ");
                }
            }
            //소지 금액이 20만원 미만일시 살 수 있는 게 없으므로
            else{
                System.out.println("그 금액으로는 사실 수 있는 폰이 아무것도 없습니다.");
            }

        }

        //입력한 값이 안드로이드일 경우
        else if(choice.equals("android")){
            //안드로이드 객체 생성
            android ad1 = new android();
            System.out.println("소유하고 계시는 금액을 입력하세요");
            
            int havePrice = scan.nextInt();
            ad1.setPrice(havePrice);
            
            if(havePrice>=200000){
                System.out.println("원하는 기종을 입력하시오.");
                ad1.menu();

                String wantType = scan.next();
                ad1.setName(wantType);
                
                if(wantType=="galaxys8"&&(havePrice>=200000)){
                    ad1.sell();
                }
                
                else if(wantType.equals("galaxys8+")&&(havePrice>=300000)){
                    ad1.sell();
                }
                
                else if(wantType.equals("galaxynote9")&&(havePrice>=400000)){
                    ad1.sell();
                }
                
                else if(wantType.equals("galaxynote10")&&(havePrice>=500000)){
                    ad1.sell();
                }
                
                else{
                    System.out.println("금액 부족입니다. 금액 내에서 골라주세요ㅠ");
                }
            }

            else{
                System.out.println("그 금액으로는 사실 수 있는 폰이 아무것도 없습니다.");
            }
            
        }
        //android와 iphone 외에 다른 것을 입력하였을 경우
        else{
            System.out.println("입력오류입니다.");
        }
        
        scan.close();
    }
}