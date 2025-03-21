const base = {
    get() {
        return {
            url : "http://localhost:8080/nongchanguanlixitong/",
            name: "nongchanguanlixitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/nongchanguanlixitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "农场管理系统"
        } 
    }
}
export default base
