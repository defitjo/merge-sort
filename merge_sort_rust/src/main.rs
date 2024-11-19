fn main() {
    let mut arr = vec![5, 1, 9, 10, 8, 3, 7, 2, 6, 4];
    merge_sort(&mut arr);
    println!("{:?}", arr);
}

fn merge_sort(arr: &mut [i32]) {
    let size = arr.len();
    if size > 1 {
        let mid = size / 2;
        let (left, right) = arr.split_at_mut(mid);

        merge_sort(left);
        merge_sort(right);

        let mut temp = vec![0; size];
        merge(left, right, &mut temp);

        arr.copy_from_slice(&temp);
    }
}

fn merge(left: &[i32], right: &[i32], temp: &mut [i32]) {
    let mut i = 0;
    let mut j = 0;
    let mut k = 0;

    while i < left.len() && j < right.len() {
        if left[i] < right[j] {
            temp[k] = left[i];
            i += 1;
        } else {
            temp[k] = right[j];
            j += 1;
        }
        k += 1;
    }

    while i < left.len() {
        temp[k] = left[i];
        i += 1;
        k += 1;
    }

    while j < right.len() {
        temp[k] = right[j];
        j += 1;
        k += 1;
    }
}
