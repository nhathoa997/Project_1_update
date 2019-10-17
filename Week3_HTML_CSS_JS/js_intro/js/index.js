const DOMModule = (function(){
    class DOM {
        static createElement(elemName, elemAttributes) {
            const elem = document.createElement(elemName);
            
            for(let key in elemAttributes) {
                if(key.startsWith('data-')) {
                    elem.setAttribute(key, elemAttributes[key]);
                } else {
                    elem[key] = elemAttributes[key];
                }
            }

            return elem;
        }

        static addEventListener(elem, event, cb) {
            elem.addEventListener(event, cb);
        }
    }

    return {
        DOM
    }
})();

const AppModule = (function() {

    class Application {
        constructor(){}

        run() {
            console.log("This application doesn't do anything");
        }
    }

    return {
        //Application: Application
        Application
    }

})();

const DOM = DOMModule.DOM;

const TodoAppModule = (function(){
    class TodoApp extends AppModule.Application {
        constructor(root) {
            super(); //this must be done in the extending class's constructor
            this._todos = []
            this._root = root;
        }

        run() {
            this._render();
        }

        get todos() {
            return this._todos;
        }

        set todos(todos) {
            if(todos.length) {
                this._todos = todos;
            } else {
                this._todos = [];
            }
            this._render();
        }

        _render() {
            this._root.innerText = "";

            const title = DOM.createElement('h1', {
                "id": "welcome-text",
                "className": "text-bigger text-center",
                "data-value": "some-nonsense",
                "innerText": "Welcome to Todo-IT"
            });

            const todoList = DOM.createElement('ul', {
                "className": "todo-list"
            });



            this._todos.forEach(element => {
                const del = DOM.createElement('button', {
                    "className": "del-button",
                    "innerText": "X"
                });

                DOM.addEventListener(del, 'click', (event) => {
                    event.preventDefault();
                    const parent = event.target.parentNode;
                    console.log(parent);
                    parent.remove();
                });

                const li = DOM.createElement('li', {
                    "className": "todo-item",
                    "innerText": element
                });

                DOM.addEventListener(li, 'click', (event) => {
                    event.stopPropagation();
                    alert(event.target.innerText);
                });

                li.appendChild(del);

                todoList.appendChild(li);
            });

            this._root.appendChild(title);
            this._root.appendChild(todoList);
        }
    }

    return {
        TodoApp
    }
})();

const app = (new TodoAppModule.TodoApp(document.querySelector('#root')));
app.run();
app.todos = ["Paint the Fence", "Wax the Car"];