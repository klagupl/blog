
export class PostModel {
    public postId:number;
    public title: string;
    public preview: string;
    public content: string;
    public image: string;
    public date: string;

    constructor(postId: number, title:string, preview: string, content:string,image:string,date:string){
        this.postId=postId;
        this.title=title;
        this.preview=preview;
        this.content=content;
        this.image=image;
        this.date=date;
    }

}