function loadBlogs(page, append) {
    $.ajax({
        type: "GET",
        url: 'http://localhost:8080/blog',
        headers: {
            "Content-Type": "application/json",
        },
        success: function (data) {
            renderBlog(data.content, append);
            renderLoadMoreButton(data);
        },
        error: function (error) {
            console.log(error);
        },
    });
}

$(document).ready(function () {
    loadBlogs();
})

function loadMore(nextPage) {
    loadBlogs((nextPage, true));
}

function renderLoadMoreButton(blogPageData) {
    if (blogPageData.number < blogPageData.totalPage - 1) {
        $("loadMoreContainer").html(
            `
                <button type="button" class="btn btn-secondary"
                onclick="loadMore(${blogPageData.number + 1})">
                Load More
                </button>
            `
        );
    } else {
        $("#loadMoreContainer").remove();
    }
}

function renderBlog(blogs, append) {
    let element = `
                    <thead>
                        <tr>
                            <th>Mã Số</th>
                            <th>Tên Tác Giả</th>
                            <th>Tiêu Đề</th>
                            <th>Thể Loại</th>
                        </tr>
                    </thead>
                    <tbody>;
                   `
    for (let blog of blogs) {
        element += `
        <tr>
            <td>${blog.id}</td>
            <td>${blog.authorName}</td>
            <td>${blog.title}</td>
            <td>${blog.categoryDTO.name}</td>
        </tr> 
        `;
    }
    element += "</tbody>";

    if (append) {
        $("#listBlogs").append(element);
    } else {
        $("#listBlogs").html(element);
    }
}