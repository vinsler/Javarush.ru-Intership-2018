package notes.servlets;

import notes.Services.NoteService;
import notes.Services.UserService;
import notes.model.Note;
import notes.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class viewnoteServlet extends HttpServlet {
    private NoteService noteService = new NoteService();
    private final UserService USER_SERVICE = new UserService();


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user = (User) req.getSession().getAttribute("user");
        Note note = new Note();
        note.setUser(USER_SERVICE.findLogin(user));

        List<Note> notelist = noteService.findLoginNote(note);

        List<Note> srtlist = (List<Note>)req.getSession().getAttribute("sortnote");
        if (srtlist == null) {
            req.setAttribute("listnote", notelist);
        } else {
            req.setAttribute("listnote", srtlist);
        }

        req.setAttribute("user", user);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/viewnote.jsp");
        dispatcher.forward(req, resp);
    }
}
