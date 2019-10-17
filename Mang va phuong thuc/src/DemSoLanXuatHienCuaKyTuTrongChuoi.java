public class DemSoLanXuatHienCuaKyTuTrongChuoi {
    public static void main(String[] args) {
        String str = "abcabcdef";
        char character = 'a';
        int count = 0;
        for (int i=0; i<str.length();i++){
            if (str.charAt(i)==character)
                count++;
        }
        System.out.println(count);
    }
}
