console.log('test-a', 'start');

let value1 = localStorage.getItem('key1');
if (!value1) {
    localStorage.setItem("key1", "vvv")
}