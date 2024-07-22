package enums;

public class Runner {
    public static void main(String[] args) {

        //strength:LOW
        printMessageForPasswordStrength("LOW");

        //strength:MEDIUM
        printMessageForPasswordStrength("Medium"); //CTE, RTE yok fakat istenen sonucu vermiyor.

//ÇÖZÜM: metodun parametresini enum type olarak almak

        System.out.println("-----------------------------------");
        prinMessageForPasswordStrengthByEnums(PasswordStrengthEnum.LOW);
        prinMessageForPasswordStrengthByEnums(PasswordStrengthEnum.MEDIUM);
        prinMessageForPasswordStrengthByEnums(PasswordStrengthEnum.HIGH);
    }
    //Kullanıcının şifresinin seviyesi belirlendiğinde
//kullanıcıya mesaj gönderen bir metod yazalım.

    public static void printMessageForPasswordStrength(String strength){
        if(strength.equals(PasswordStrength.LOW)){
            System.out.println("Dikkat şifreniz yetersiz seviyededir");
        }else if(strength.equals(PasswordStrength.MEDIUM)){
            System.out.println("Şifre gücünüz orta düzeydedir");
        }else if(strength.equals(PasswordStrength.HIGH)){
            System.out.println("Tebrikler şifre gücünüz yüksek düzeydedir");
        }


    }

    //aynı metodu enum type kullanarak yapalım
    public static void prinMessageForPasswordStrengthByEnums(PasswordStrengthEnum strength){
        if(strength.equals(PasswordStrengthEnum.LOW)){
            System.out.println("Dikkat şifreniz yetersiz seviyededir");
        }else if(strength.equals(PasswordStrengthEnum.MEDIUM)){
            System.out.println("Şifre gücünüz orta düzeydedir");
        }else if(strength.equals(PasswordStrengthEnum.HIGH)){
            System.out.println("Tebrikler şifre gücünüz yüksek düzeydedir");
        }

        System.out.println("Enum sırası : "+strength.ordinal());
        System.out.println("Enum ismi : "+strength.name());

    }

}


