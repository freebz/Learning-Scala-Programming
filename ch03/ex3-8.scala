// Why recursion over iteration?

def power2toN(n: Int): Int = if(n == 0) 1 else 2 * power2toN(n - 1)
