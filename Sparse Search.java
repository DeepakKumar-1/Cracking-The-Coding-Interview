public class SparseSearch {

    static int search(String [] strings, String str){
        if(strings == null || str == null || str.equals(""))
            return -1;
        return search(strings, str, 0, strings.length - 1);
    }

    private static int search(String[] strings, String str, int start, int end) {
        if(start > end)
            return -1;
        // Find mid
        int mid = start + (end - start)/2;

        // if mid is Empty then find the Closest Non-Empty String
        if(strings[mid].isEmpty()){
            int left = mid-1;
            int right = mid+1;
            while(true){
                if(left < start && right > end)
                    return -1;
                else if(right <= end && !strings[right].equals("")){
                    mid = right;
                    break;
                } else if(left >= start && !strings[left].equals("")){
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }

        // Check for the String and recurse if Necessary
        if(str.equals(strings[mid]))
            return mid;
        else if(strings[mid].compareTo(str) < 0)
            return search(strings, str, mid+1, end);
        else
            return search(strings, str, start, mid-1);
    }

    public static void main(String [] args){
        String [] strings = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println(search(strings, "ball"));
    }
}
